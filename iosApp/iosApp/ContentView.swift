import SwiftUI

struct ContentView: View {

    private let cancelScope: () -> ()
    private let emit: () -> ()

    init(cancelScope: @escaping () -> (), emit: @escaping () -> ()) {
        self.cancelScope = cancelScope
        self.emit = emit
    }

    var body: some View {
        VStack {
            Button(action: cancelScope, label: {
                Text("Cancel Scope")
            })
            Button(action: emit, label: {
                Text("Emit")
            })
        }
    }
}
