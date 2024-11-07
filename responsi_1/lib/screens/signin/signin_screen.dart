import 'package:flutter/gestures.dart';
import 'package:flutter/material.dart';
import 'package:responsi_1/utils/common_ui.dart';

class SigninScreen extends StatelessWidget {
  const SigninScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      theme: ThemeData(
          textTheme: const TextTheme(
              displaySmall:
                  TextStyle(fontFamily: 'Poppins', fontWeight: FontWeight.bold),
              headlineSmall:
                  TextStyle(fontFamily: 'Poppins', fontWeight: FontWeight.bold),
              bodyMedium: TextStyle(fontFamily: 'Poppins'),
              bodySmall: TextStyle(fontFamily: 'Poppins'))),
      home: Scaffold(
        body: Padding(
          padding: const EdgeInsets.symmetric(horizontal: 16.0),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              Padding(
                padding: const EdgeInsets.only(bottom: 40.0),
                child: Image.asset('assets/images/app_logo.png'),
              ),
              Padding(
                padding: const EdgeInsets.only(bottom: 44.0),
                child: Text(
                  'Daftar',
                  style: Theme.of(context).textTheme.displaySmall,
                ),
              ),
              Padding(
                padding: const EdgeInsets.only(bottom: 40.0),
                child: TextFieldWithLabel(
                    label: 'Masukan Email',
                    hint: "Email",
                    labelStyle: Theme.of(context).textTheme.bodyMedium,
                    hintStyle: Theme.of(context).textTheme.bodySmall,
                    isObscure: false,
                    keyboardType: TextInputType.emailAddress,
                    textInputAction: TextInputAction.next),
              ),
              Padding(
                padding: const EdgeInsets.only(bottom: 12.0),
                child: TextFieldWithLabel(
                    label: 'Masukan Password',
                    hint: "Password",
                    labelStyle: Theme.of(context).textTheme.bodyMedium,
                    hintStyle: Theme.of(context).textTheme.bodySmall,
                    isObscure: true,
                    keyboardType: TextInputType.text,
                    textInputAction: TextInputAction.done),
              ),
              Padding(
                padding: const EdgeInsets.only(bottom: 48.0),
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: [
                    RichText(
                      text: TextSpan(
                          text: 'Belum punya akun? ',
                          style: Theme.of(context).textTheme.bodyMedium,
                          children: [
                            TextSpan(
                                text: 'Daftar',
                                style: Theme.of(context)
                                    .textTheme
                                    .bodyMedium!
                                    .copyWith(color: const Color(0xFF4285F4)),
                                recognizer: TapGestureRecognizer()
                                  ..onTap = () {
                                    //
                                  })
                          ]),
                    ),
                    RichText(
                        text: TextSpan(
                            text: 'Lupa Password',
                            style: Theme.of(context)
                                .textTheme
                                .bodyMedium!
                                .copyWith(color: const Color(0xFF4285F4)),
                            recognizer: TapGestureRecognizer()
                              ..onTap = () {
                                //
                              }))
                  ],
                ),
              ),
              FilledButton(
                onPressed: null,
                style: FilledButton.styleFrom(
                    backgroundColor: const Color(0xFF4285F4),
                    foregroundColor: Colors.white),
                child: Text(
                  'Masuk',
                  style: Theme.of(context).textTheme.headlineSmall,
                ),
              )
            ],
          ),
        ),
      ),
    );
  }
}
