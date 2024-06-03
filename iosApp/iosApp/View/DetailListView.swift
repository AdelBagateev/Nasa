import SwiftUI

struct DetailListView: View {
    var detailsList: [AsteroidDetails]
    @State private var searchText = ""
    @Environment(\.colorScheme) var colorScheme
    
    var body: some View {
        NavigationView {
            List {
                ForEach(filteredAsteroids) { asteroid in
                    NavigationLink(destination: DetailAboutObjectView(detailInfo: asteroid)) {
                        HStack {
                            AsyncImage(url: URL(string: asteroid.imageUrl)) { image in
                                image.resizable()
                                     .aspectRatio(contentMode: .fit)
                                     .frame(width: 150, height: 120)
                            } placeholder: {
                                ProgressView()
                                    .frame(width: 150, height: 120)
                            }
                            
                            VStack(alignment: .leading) {
                                Text(asteroid.name.capitalized)
                                    .font(.custom("TerminaTest-Medium", size: 18))
                                    .foregroundColor(ThemeManager.textColor(for: colorScheme))
                                
                                Text(asteroid.description)
                                    .font(.custom("TerminaTest-Medium", size: 12))
                                    .foregroundColor(ThemeManager.textColor(for: colorScheme))
                                    .lineLimit(2)
                            }
                        }
                    }
                }
            }
            .searchable(text: $searchText)
            .navigationTitle("Asteroids")
        }
    }
    
    var filteredAsteroids: [AsteroidDetails] {
        if searchText.isEmpty {
            return detailsList
        } else {
            return detailsList.filter { $0.name.lowercased().contains(searchText.lowercased()) }
        }
    }
}
