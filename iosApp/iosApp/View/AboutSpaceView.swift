import SwiftUI

struct AboutSpaceView: View {
    var body: some View {
        CustomBackgroundView()
            .overlay(
                VStack {
                    Text("ABOUT SPACE")
                        .font(.custom("TerminaTest-ExtraLight", size: 32))
                        .foregroundColor(.gray)
                        .padding()
                    
                    CollectionView(data: DataType(id: 1, rows: [
                        Row(title: "ASTEROIDS", image: "asteroids"),
                        Row(title: "PLANETS", image: "planets")
                    ]))
                }
            )
    }
}
