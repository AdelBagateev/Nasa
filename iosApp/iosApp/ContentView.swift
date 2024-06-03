import SwiftUI
import Shared

struct ContentView: View {
    @State var tabSelection = 1
    
//    var viewModel: AboutSpaceViewModel
    
    var body: some View {
        NavigationView {
            ZStack {
                TabView(selection: $tabSelection) {
                    AboutSpaceView()
                        .tag(1)
                    
                    GenerateView()
                        .tag(2)
                }
                .overlay(alignment: .bottom) {
                    TabBarView(tabSelection: $tabSelection)
                }
            }
            .navigationTitle("")
        }
    }
}
