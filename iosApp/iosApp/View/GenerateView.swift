import SwiftUI
import Shared

struct GenerateView: View {
    @Environment(\.colorScheme) var colorScheme
    @State private var showImage = false
    @State private var imageUrl: URL?
    
    @StateObject private var viewModel = PhotoByCoordinatesViewModelWrapper()

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
                            // Replace with actual coordinates
                            viewModel.getPhotoByCoordinates(lat: 0, lon: 0)
                        }) {
                            Image(systemName: "hand.tap")
                                .foregroundColor(ThemeManager.textColor(for: colorScheme))
                                .font(.system(size: 30))
                        }
                    }
                    .padding(.top, 5)
                }
            )
            .sheet(isPresented: $showImage) {
                if let imageUrl = viewModel.satellitePhotoUrl {
                    ImageWindowView(imageUrl: imageUrl)
                }
            }
            .onReceive(viewModel.$satellitePhotoUrl) { url in
                if url != nil {
                    showImage = true
                    imageUrl = url
                }
            }
    }
}
