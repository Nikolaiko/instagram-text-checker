import SwiftUI
import ComposeApp

struct OnBoardingView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        OnBoardingViewControllerKt.OnBoardingViewController()
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}
