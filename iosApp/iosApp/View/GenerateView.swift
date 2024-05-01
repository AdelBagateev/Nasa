import SwiftUI

struct GenerateView: View {
    var body: some View {
        CustomBackgroundView()
            .overlay(
                VStack {
                    Text("GENERATE")
                        .font(.custom("TerminaTest-Black", size: 25))
                        .foregroundColor(.gray)
                    
                    Text("Satellite photo")
                        .font(.custom("TerminaTest-ExtraLight", size: 16))
                        .foregroundColor(.gray)
                    
                    VStack(alignment: .center, spacing: -50) {
                        HStack {
                            EnterGenerateFieldView(fieldName: "Longitude")
                            EnterGenerateFieldView(fieldName: "Latitude")
                        }
                        Button(action: {
                            print("Кнопка была нажата")
                        }) {
                            Image(systemName: "hand.tap")
                                .foregroundColor(.gray)
                                .font(.system(size: 30))
                        }
                    }
                }
                
            )
    }
}

