import shared
import UIKit
import SwiftUI

class SceneDelegate: UIResponder, UIWindowSceneDelegate {

    var window: UIWindow?

    func scene(_ scene: UIScene, willConnectTo session: UISceneSession, options connectionOptions: UIScene.ConnectionOptions) {
        guard let windowScene = scene as? UIWindowScene else { return }

        let flow = ConcreteUnitFlow()
//         let flow = ConcreteUnitFlowNoInterface() // uncomment to fix
        let coroutineLauncher = CoroutineLauncher(flow: flow)
        let contentView = ContentView(
            cancelScope: {
                coroutineLauncher.cancelScope()
            },
            emit: {
                flow.emit()
            }
        )

        let window = UIWindow(windowScene: windowScene)
        window.rootViewController = UIHostingController(rootView: contentView)
        self.window = window
        window.makeKeyAndVisible()
    }
}
