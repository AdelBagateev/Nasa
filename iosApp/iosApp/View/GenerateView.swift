import SwiftUI

struct GenerateView: View {
    @Environment(\.colorScheme) var colorScheme
    
    var body: some View {
        CustomBackgroundView()
            .overlay(
                VStack {
                    Text("GENERATE")
                        .font(.custom("TerminaTest-Black", size: 25))
                        .foregroundColor(ThemeManager.textColor(for: colorScheme))
                    
                    Text("Satellite photo")
                        .font(.custom("TerminaTest-ExtraLight", size: 16))
                        .foregroundColor(ThemeManager.textColor(for: colorScheme))
                    
                    VStack(alignment: .center, spacing: 20) {
                        HStack {
                            EnterGenerateFieldView(fieldName: "Longitude")
                            EnterGenerateFieldView(fieldName: "Latitude")
                        }
                        
                        Spacer().frame(height: 5) 
                        
                        Button(action: {
                            print("Button was pressed")
                        }) {
                            Image(systemName: "hand.tap")
                                .foregroundColor(ThemeManager.textColor(for: colorScheme))
                                .font(.system(size: 30))
                        }
                    }
                    .padding(.top, 5)
                }
            )
    }
}
