import SwiftUI

struct DetailListView: View {
    var row: Row
    var detailsList = asteroidsList
    @State var searchText = ""
    @Environment(\.colorScheme) var colorScheme
    
    var body: some View {
        NavigationView {
            List {
                ForEach(asteroids, id: \.id) { asteroid in
                    NavigationLink(destination: DetailAboutObjectView(detailInfo: asteroid)) {
                        HStack {
                            Image(asteroid.image)
                                .resizable()
                                .aspectRatio(contentMode: .fit)
                                .frame(width: 150, height: 120)
                            
                            VStack(alignment: .leading) {
                                Text(asteroid.title.capitalized)
                                    .font(.custom("TerminaTest-Medium", size: 18))
                                    .foregroundColor(ThemeManager.textColor(for: colorScheme))
                                
                                Text(asteroid.title.capitalized)
                                    .font(.custom("TerminaTest-Medium", size: 12))
                                    .foregroundColor(ThemeManager.textColor(for: colorScheme))
                            }
                        }
                    }
                }
            }
            .searchable(text: $searchText)
        }
    }
    
    var asteroids: [Row] {
        _ = detailsList.map { $0.title.lowercased() }
        
        return searchText.isEmpty ? detailsList : detailsList.filter {
            $0.title.lowercased().contains(searchText.lowercased())
        }
    }
}

var asteroidsList: [Row] = [
    Row(title: "Title", text: "TextvfefewewvfewfewvfewvfewvTextvfefewewvfewfewvfewvfewvTextvfefewewvfewfewvfewvfewvTextvfefewewvfewfewvfewvfewvTextvfefewewvfewfewvfewvfewvTextvfefewewvfewfewvfewvfewvTextvfefewewvfewfewvfewvfewvTextvfefewewvfewfewvfewvfewvTextvfefewewvfewfewvfewvfewvTextvfefewewvfewfewvfewvfewv", image: "asteroids"),
    Row(title: "fgf", text: "Text", image: "asteroids"),
    Row(title: "dfgd", text: "Text", image: "asteroids")
]
