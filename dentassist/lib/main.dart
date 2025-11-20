import 'package:flutter/material.dart';
import 'widgets/ChatScreen.dart';

void main() {
  runApp(const DentAssistApp());
}

class DentAssistApp extends StatelessWidget {
  const DentAssistApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'DentAssist',
      theme: ThemeData.dark(),
      home: const ChatScreen(),
    );
  }
}
