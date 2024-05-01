import Foundation

struct Row: Identifiable {
    public let id = UUID()
    public let title: String
    var text: String?
    var image: String
}
