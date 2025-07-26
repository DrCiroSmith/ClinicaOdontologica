import 'package:flutter_test/flutter_test.dart';
import 'package:dentassist/main.dart';

void main() {
  testWidgets('App builds', (WidgetTester tester) async {
    await tester.pumpWidget(const DentAssistApp());
    expect(find.text('DentAssist'), findsOneWidget);
  });
}
