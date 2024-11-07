import 'package:flutter/material.dart';

class TextFieldWithLabel extends StatelessWidget {
  const TextFieldWithLabel(
      {required this.label,
      required this.hint,
      required this.labelStyle,
      required this.hintStyle,
      required this.isObscure,
      required this.keyboardType,
      required this.textInputAction,
      super.key});

  final String label;
  final String hint;
  final TextStyle? labelStyle;
  final TextStyle? hintStyle;
  final bool isObscure;
  final TextInputType keyboardType;
  final TextInputAction textInputAction;

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Column(
        children: [
          Padding(
              padding: const EdgeInsets.only(bottom: 4.0),
              child: Text(
                label,
                style: labelStyle,
              )),
          Padding(
              padding: const EdgeInsets.only(bottom: 4.0),
              child: TextField(
                obscureText: isObscure,
                keyboardType: keyboardType,
                textInputAction: textInputAction,
                maxLines: 1,
                decoration: InputDecoration(
                    hintText: hint,
                    hintStyle: hintStyle,
                    border: const OutlineInputBorder(),
                    enabledBorder: const OutlineInputBorder(
                        borderSide: BorderSide(color: Color(0xFF4285F4))),
                    focusedBorder: const OutlineInputBorder(
                        borderSide:
                            BorderSide(color: Color(0xFF4285F4), width: 1.5))),
              )),
        ],
      ),
    );
  }
}
