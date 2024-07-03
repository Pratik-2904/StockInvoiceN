package com.example.stockinvoice.ViewModels


import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.stockinvoice.DataBase.SharedPref
import com.example.stockinvoice.DataBase.usermodel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class authVM : ViewModel() {
    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseDatabase.getInstance()
    private val userRef = db.getReference("users")

    private val _firebaseUser = MutableLiveData<FirebaseUser?>()
    val firebaseUser: LiveData<FirebaseUser?> = _firebaseUser

    init {
        _firebaseUser.value = auth.currentUser
    }

    fun login(mail: String, password: String, context: Context) {
        if (mail.isEmpty() || password.isEmpty()) {
            Toast.makeText(context, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
            return
        }
        auth.signInWithEmailAndPassword(mail, password)
            .addOnFailureListener {
                Toast.makeText(context, "Enter valid credentials", Toast.LENGTH_SHORT).show()
            }
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    _firebaseUser.postValue(auth.currentUser)
                    Toast.makeText(context, "Login successful! Fetching data", Toast.LENGTH_SHORT).show()
                    getData(auth.currentUser!!.uid, context)
                }
            }
    }

    private fun getData(uid: String, context: Context) {
        userRef.child(uid).addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val userData = snapshot.getValue(usermodel::class.java)
                userData?.let {
                    SharedPref.storeData(
                        it.name, it.mail, it.Phonenum, it.GSTnum, it.uid.toString(), context
                    )
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "Failed to fetch data", Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun signup(name: String, mail: String, Phonenum: String,GSTnum:String,password: String, context: Context) {
        auth.createUserWithEmailAndPassword(mail, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    user?.sendEmailVerification()
                        ?.addOnCompleteListener { verifyTask ->
                            if (verifyTask.isSuccessful) {
                                Toast.makeText(context, "Verification email sent. Please check your email.", Toast.LENGTH_SHORT).show()
                            } else {
                                Toast.makeText(context, "Failed to send verification email: ${verifyTask.exception?.message}", Toast.LENGTH_SHORT).show()
                            }
                        }
                } else {
                    Toast.makeText(context, "Signup failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }

    // Function to be called after the user verifies their email
    fun continueSignup(name: String,mail: String,Phonenum: String,GSTnum:String,password:String, uid: String,context: Context) {
        val user = auth.currentUser
        if (user != null) {
            user.reload().addOnCompleteListener {
                if (user.isEmailVerified) {
                    val uid = user.uid
                    _firebaseUser.postValue(user)
                   savedata(name,mail,Phonenum,GSTnum,password,uid,context)
//                  Toast.makeText(context,"data saved ",Toast.LENGTH_SHORT).show()
//
                } else {
                    Toast.makeText(context, "Email not verified. Please verify your email first.", Toast.LENGTH_SHORT).show()
                }
            }
        } else {
            Toast.makeText(context, "User is null. Please sign in again.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun savedata(name: String, mail: String, Phonenum: String,GSTnum:String, password: String, uid: String?, context: Context) {
        val data = usermodel(name,mail,Phonenum,GSTnum,password,uid!!)
        userRef.child(uid).setValue(data)
            .addOnSuccessListener {
                SharedPref.storeData(name, mail, Phonenum,GSTnum, uid, context)
                Toast.makeText(context, "Data saved", Toast.LENGTH_SHORT).show()

            }
            .addOnFailureListener {
                Toast.makeText(context, "Failed to save data", Toast.LENGTH_SHORT).show()
            }
    }

    fun logout(context: Context) {
        auth.signOut()
        _firebaseUser.postValue(null)
        SharedPref.storeData(null,null,null,null,null,context)
    }

///**********************below code is for phone authentication**********************************



//    fun verification(phonenumber:String){
//        val options = PhoneAuthOptions.newBuilder(auth)
//            .setPhoneNumber(phonenumber) // Phone number to verify
//            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
//            .setActivity(this) // Activity (for callback binding)
//            .setCallbacks(callbacks) // OnVerificationStateChangedCallbacks
//            .build()
//        PhoneAuthProvider.verifyPhoneNumber(options)
//    }




}




















// *******use below function for saving image if needed*******

//    private val storageRef = Firebase.storage.reference

//    private fun saveImage(mail: String, password: String, name: String, username: String, bio: String, imageuri: Uri?, uid: String?, context: Context) {
//        imageuri?.let {
//            val imageRef = storageRef.child("user/${UUID.randomUUID()}.jpg")
//            val uploadTask = imageRef.putFile(it)
//            uploadTask.addOnSuccessListener {
//                imageRef.downloadUrl.addOnSuccessListener { uri ->
//                    savedata(mail, password, name, bio, username, uri.toString(), uid, context)
////                    Toast.makeText(context, "Registration Succefull!! ", Toast.LENGTH_SHORT).show()
//                }
//            }.addOnFailureListener {
//                Toast.makeText(context, "Image upload failed", Toast.LENGTH_SHORT).show()
//            }
//        } ?: Toast.makeText(context, "Image URI is null", Toast.LENGTH_SHORT).show()
//    }
