import SwiftUI

struct RowView: View {
    var row: Row
    
    var body: some View {
        VStack(spacing: 18) {
            VStack {
                HStack {
                    Text(row.title)
                        .foregroundColor(.gray)
                        .font(.custom("TerminaTest-Black", size: 20))
                    
                    Spacer()
                    
                    Text("see all")
                        .foregroundColor(.gray)
                        .font(.custom("TerminaTest-Medium", size: 12))
                }
                
                Image(row.image)
                    .resizable()
                    .frame(width: 350, height: 216)
                    .scaledToFit()
            }
        }
    }
}
