import SwiftUI

struct CustomBackgroundView: View {
    var body: some View {
        GeometryReader { geo in
            ZStack {
                Image("background")
                    .resizable()
                    .scaledToFill()
                    .edgesIgnoringSafeArea(.all)
                    .frame(width: geo.size.width,
                           height: geo.size.height)
                    .opacity(1.0)
            }
        }
        .background(Color.black)
    }
}
