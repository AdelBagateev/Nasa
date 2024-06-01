import SwiftUI

struct OvalTextFieldStyle: TextFieldStyle {
    @Environment(\.colorScheme) var colorScheme

    func _body(configuration: TextField<Self._Label>) -> some View {
        configuration
            .padding(10)
            .background(ThemeManager.textFieldColor(for: colorScheme))
            .cornerRadius(10)
    }
}
