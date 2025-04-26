import UIKit
import SwiftUI
import ComposeApp

struct ContentView: View {
    var body: some View {
        OnBoardingView()
                .ignoresSafeArea(.keyboard) // Compose has own keyboard handler
    }
}




