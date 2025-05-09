import SwiftUI
import ComposeApp

struct AppViewController: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        AppViewControllerKt.AppViewController()
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}
