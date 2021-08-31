package com.dhxxn.practice1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.BehaviorSubject
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    private lateinit var editPw : EditText
    private lateinit var editPwCheck: EditText
    private lateinit var textView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editPw = findViewById(R.id.edit_pw)
        editPwCheck = findViewById(R.id.edit_pw_check)
        textView = findViewById(R.id.textView)

        /*
        비밀번호 조건
        1. 영어 소문자 대문자 숫자만 가능
        2. 특수 문자는 ! " # $ % & ' ( ) * + , - . / : ; < = > ? @ [ ＼ ] ^ _ ` { | } ~ \) 만 가능
        3. 공백 포함 불가능
        4. 8 ~ 16자까지 가능
         */

        val subject : BehaviorSubject<String> = BehaviorSubject.createDefault("")

        editPw.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                subject.map { editPw.text.toString() }.flatMap { input ->
                    Observable.just(input)
                }.scan { it1, it2 -> "${it1.trim()}${it2.trim()}"}.subscribe(
                    {
                    textView.text = it
                    if (it.length < 8 || it.length > 16) {
                        editPw.error = "비밀번호는 8~16자 까지 가능합니다"
                    }
                    },
                    { Log.e("MainActivity", "error!")}
                )

            }

            override fun afterTextChanged(s: Editable?) {

            }

        })

        editPwCheck.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                subject.map { editPwCheck.text.toString() }.flatMap { input ->
                    Observable.just(input)
                }.scan{it1, it2 -> "${it1.trim()}${it2.trim()}"}.subscribe {
                    if (editPw.text.toString() != it) {
                        editPwCheck.error = "비밀번호를 다시 확인해주세요"
                    }
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
    }
}