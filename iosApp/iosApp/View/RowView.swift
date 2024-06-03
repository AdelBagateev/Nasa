import SwiftUI

struct RowView: View {
    var row: Row
    @Environment(\.colorScheme) var colorScheme
    
    var body: some View {
        VStack(spacing: 18) {
            VStack {
                HStack {
                    Text(row.title)
                        .foregroundColor(ThemeManager.textColor(for: colorScheme))
                        .font(.custom("TerminaTest-Black", size: 20))
                    
                    Spacer()
                    
                    Text("see all")
                        .foregroundColor(ThemeManager.textColor(for: colorScheme))
                        .font(.custom("TerminaTest-Medium", size: 12))
                }
                
                Image(row.image)
                    .resizable()
                    .scaledToFit()
                    .frame(width: 350, height: 216)
            }
        }
        .padding() 
    }
}
