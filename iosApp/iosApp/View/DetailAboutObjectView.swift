import SwiftUI

struct DetailAboutObjectView: View {
    var detailInfo: AsteroidDetails
    @Environment(\.presentationMode) var presentationMode: Binding<PresentationMode>
    @Environment(\.colorScheme) var colorScheme
    
    var body: some View {
        CustomBackgroundView()
            .navigationBarBackButtonHidden(true)
            .overlay(
                VStack(alignment: .leading, spacing: 16) {
                    HStack {
                        Button(action: {
                            presentationMode.wrappedValue.dismiss()
                        }) {
                            Image(systemName: "chevron.left")
                                .foregroundColor(ThemeManager.textColor(for: colorScheme))
                        }
                        Spacer()
                    }
                    .padding(.horizontal)

                    Text(detailInfo.name)
                        .font(.custom("TerminaTest-Bold", size: 22))
                        .foregroundColor(ThemeManager.textColor(for: colorScheme))
                        .padding(.horizontal)
                    
                    AsyncImage(url: URL(string: detailInfo.imageUrl)) { image in
                        image.resizable()
                             .aspectRatio(contentMode: .fit)
                             .frame(width: 350, height: 330)
                             .padding(.horizontal)
                    } placeholder: {
                        ProgressView()
                            .frame(width: 350, height: 330)
                            .padding(.horizontal)
                    }
                    
                    Text(detailInfo.description)
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
