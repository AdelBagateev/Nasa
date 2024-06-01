import SwiftUI

struct ThemeManager {
    static func textColor(for colorScheme: ColorScheme) -> Color {
        return colorScheme == .dark ? .gray : .customGray
    }
    
    static func backgroundColor(for colorScheme: ColorScheme) -> Color {
        return colorScheme == .dark ? .black : .white
    }
    
    static func tabBarColor(for colorScheme: ColorScheme) -> Color {
        return colorScheme == .dark ? .white : .black
    }
    
    static func tabBarIconColor(for colorScheme: ColorScheme) -> Color {
        return colorScheme == .dark ? .white : .customGray
    }
    
    static func textFieldColor(for colorScheme: ColorScheme) -> Color {
        return colorScheme == .dark ? .customTextFieldDarkGray : .customTextFieldGray
    }
}
