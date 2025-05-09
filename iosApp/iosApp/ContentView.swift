import UIKit
import SwiftUI
import ComposeApp

struct ContentView: View {
    var body: some View {
        AppViewController()
                .ignoresSafeArea(.keyboard) // Compose has own keyboard handler
    }
}




