import Foundation

class myClass {  // Error: lowercase class name
    var password = "hardcoded123"  // Error: hardcoded password
    
    
    func getData() {
        let url: URL = someValue as! URL  // Error: force cast
        let value: String = data!  // Error: force unwrap
        try! performAction()  // Error: force-try
    }
}