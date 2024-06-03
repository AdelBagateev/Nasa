import SwiftUI
import Combine
import Shared

struct AboutSpaceView: View {
    @Environment(\.colorScheme) var colorScheme
//    var viewModel: AboutSpaceViewModel
    
    var body: some View {
        CustomBackgroundView()
            .overlay(
                VStack {
                    Text("ABOUT SPACE")
                        .font(.custom("TerminaTest-ExtraLight", size: 32))
                        .foregroundColor(ThemeManager.textColor(for: colorScheme))
                        .padding()
                    
                    CollectionView(data: DataType(id: 1, rows: [
                        Row(title: "ASTEROIDS", image: "asteroids"),
                        Row(title: "PLANETS", image: "planets")
                    ]))
                }
            )
    }
}
