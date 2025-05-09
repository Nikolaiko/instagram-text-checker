import SwiftUI
import ComposeApp

@main
struct iOSApp: App {

    init() {
        KoinDIKt.doInitKoin()
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
