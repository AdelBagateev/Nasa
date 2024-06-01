import SwiftUI

struct EnterGenerateFieldView: View {
    @State private var text: String = ""
    var fieldName: String
    
    var body: some View {
        VStack {
            TextField(fieldName, text: $text)
                      .font(.custom("TerminaTest-Medium", size: 12))
                      .textFieldStyle(OvalTextFieldStyle())
                      .keyboardType(.decimalPad)
        }
        .padding()
    }
}
