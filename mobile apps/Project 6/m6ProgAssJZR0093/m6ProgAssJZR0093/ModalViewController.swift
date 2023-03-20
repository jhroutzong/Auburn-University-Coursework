//
//  ModalViewController.swift
//  m6ProgAssJZR0093
//
//  Created by Jacob Routzong on 2/20/22.
//

import UIKit

class ModalViewController: UIViewController {

    var sliderVal = "none"
    var valueOf: Float = 0
    var isTrue: Bool = false
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }
    var sourceViewController: UIViewController!
    @IBAction func valueChanged(_ sender: Any) {
        sliderVal = initialSliderValue.text!
        valueOf = (sliderVal as NSString).floatValue
        if (valueOf < 0 || valueOf > 100 || valueOf.truncatingRemainder(dividingBy: 1) != 0) {
            isTrue = true;
        }
//        else {
//            isTrue = false;
//        }
    }
    
    @IBOutlet var initialSliderValue: UITextField!
    
    override func viewWillAppear(_ animated: Bool) {
        initialSliderValue.text = sliderVal
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        let svc = sourceViewController as! ViewController
        if (isTrue) {
            svc.errorLabel.text = "Invalid Slider Value Entered"
        }
        else {
            svc.slider.value = valueOf
            svc.slideValue = valueOf.description
            svc.errorLabel.text = ""
        }
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
