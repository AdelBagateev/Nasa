import SwiftUI

struct TabBarView: View {
    @Binding var tabSelection: Int
    @Namespace private var animationNapespace
    @Environment(\.colorScheme) var colorScheme
    
    let tabBarItems: [(image: String, title: String)] = [
        ("circle.grid.cross","Main"),
        ("globe.asia.australia","Generate")
    ]
    
    var body: some View {
        ZStack {
            Capsule()
                .frame(height: 60)
                .foregroundColor(ThemeManager.tabBarColor(for: colorScheme).opacity(0.1))
                .shadow(radius: 2)
            
            HStack {
                ForEach(0..<2) { index in
                    Button {
                        tabSelection = index + 1
                    } label: {
                        VStack(spacing: 8) {
                            Spacer()
                            
                            Image(systemName: tabBarItems[index].image)
                                .foregroundColor(index + 1 == tabSelection ? ThemeManager.tabBarIconColor(for: colorScheme) : .gray)
                            Text(tabBarItems[index].title)
                                .font(.caption)
                                .foregroundColor(index + 1 == tabSelection ? ThemeManager.tabBarIconColor(for: colorScheme) : .gray)
                            
                            if index + 1 == tabSelection {
                                Capsule()
                                    .frame(height: 8)
                                    .foregroundColor(.clear)
                                    .matchedGeometryEffect(id: "SelectedTabId", in: animationNapespace)
                                    .offset(y: 3)
                            } else {
                                Capsule()
                                    .frame(height: 8)
                                    .foregroundColor(.clear)
                                    .offset(y: 3)
                            }
                        }
                    }
                }
            }
            .frame(height: 80)
            .clipShape(Capsule())
        }
        .padding(.horizontal)
    }
}
