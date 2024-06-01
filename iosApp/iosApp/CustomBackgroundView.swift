import SwiftUI

import SwiftUI

struct CustomBackgroundView: View {
    @Environment(\.colorScheme) var colorScheme
    
    var body: some View {
        GeometryReader { geo in
            ZStack {
                if colorScheme == .dark {
                    Image("background")
                        .resizable()
                        .scaledToFill()
                        .edgesIgnoringSafeArea(.all)
                        .frame(width: geo.size.width, height: geo.size.height)
                        .opacity(1.0)
                }
            }
        }
        .background(ThemeManager.backgroundColor(for: colorScheme))
    }
}

