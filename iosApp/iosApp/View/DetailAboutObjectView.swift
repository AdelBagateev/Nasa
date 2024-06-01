import SwiftUI

struct DetailAboutObjectView: View {
    var detailInfo: Row
    @Environment(\.presentationMode) var presentationMode: Binding<PresentationMode>
    @Environment(\.colorScheme) var colorScheme
    
    var body: some View {
        CustomBackgroundView()
            .navigationBarBackButtonHidden(true)
            .overlay(
                VStack(alignment: .leading, spacing: -35) {
                    Text(detailInfo.title)
                        .font(.custom("TerminaTest-Bold", size: 22))
                        .foregroundColor(ThemeManager.textColor(for: colorScheme))
                        .padding(.horizontal)
                    
                    Image(detailInfo.image)
                        .resizable()
                        .aspectRatio(contentMode: .fit)
                        .frame(width: 350, height: 330)
                        .padding(.horizontal)
                    
                    Text(detailInfo.text ?? "")
                        .font(.custom("TerminaTest-Medium", size: 14))
                        .foregroundColor(ThemeManager.textColor(for: colorScheme))
                        .padding(.horizontal)
                    
                    Spacer()
                }
                .padding(.horizontal)
            )
            .background(ThemeManager.backgroundColor(for: colorScheme).edgesIgnoringSafeArea(.all))
    }
}



