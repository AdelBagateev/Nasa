import SwiftUI

struct DetailView: View {
    var row: Row
    @Environment(\.presentationMode) var presentationMode: Binding<PresentationMode>
    
    var body: some View {
        CustomBackgroundView()
            .navigationBarBackButtonHidden(true)
            .navigationBarItems(leading:
                                    Button(action: {
                presentationMode.wrappedValue.dismiss()
            }){
                Image(systemName: "chevron.left")
                    .foregroundColor(.gray)
                    .font(.system(size: 20))
                    .padding()
            }
            )
            .overlay(
                DetailListView(row: row)
            )
            .navigationBarTitleDisplayMode(.inline)
            .toolbar {
                ToolbarItem(placement: .principal) {
                    Text(row.title)
                        .font(.custom("TerminaTest-Black", size: 22))
                        .foregroundColor(.gray)
                }
            }
    }
}
