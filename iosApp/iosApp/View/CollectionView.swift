import SwiftUI

struct CollectionView: View {
    var data: DataType
    
    var body: some View {
        ScrollView {
            VStack {
                ForEach(data.rows) { row in
                    NavigationLink(destination: DetailView(row: row)) {
                        RowView(row: row)
                    }
                }
            }
        }
    }
}
