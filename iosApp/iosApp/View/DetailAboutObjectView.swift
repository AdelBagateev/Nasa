import SwiftUI

struct DetailAboutObjectView: View {
    var detailInfo: Row
    @Environment(\.presentationMode) var presentationMode: Binding<PresentationMode>
    
    var body: some View {
        CustomBackgroundView()
            .navigationBarBackButtonHidden(true)
            .overlay(
                VStack(alignment: .leading, spacing: -35) {
                    Text(detailInfo.title)
                        .font(.custom("TerminaTest-Bold", size: 22))
                        .foregroundColor(.gray)
                        .padding(.horizontal)
                    
                    Image(detailInfo.image)
                        .frame(width: 350, height: 330)
                        .padding(.horizontal)
                    
                    Text(detailInfo.text ?? "")
                        .font(.custom("TerminaTest-Medium", size: 14))
                        .foregroundColor(.gray)
                        .padding(.horizontal)
                    
                    Spacer()
                }
                .padding(.horizontal)
            )
    }
}


