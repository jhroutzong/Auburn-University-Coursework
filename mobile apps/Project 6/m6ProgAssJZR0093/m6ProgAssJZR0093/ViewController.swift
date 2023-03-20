//
//  ViewController.swift
//  m6ProgAssJZR0093
//
//  Created by Jacob Routzong on 2/20/22.
//

import UIKit

class ViewController: UIViewController {
    
    var slideValue = "None";
    @IBOutlet var slider: UISlider!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
    @IBAction func unwindLocationCancel (unwindSegue: UIStoryboardSegue) {
        
    }
    @IBAction func sliderEdited(_ sender: Any) {
        let pureValue = round(slider.value)
        slideValue = pureValue.description;
    }
    @IBOutlet var errorLabel: UILabel!
    
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if (segue.identifier == "toModalView") {
            let destVC = segue.destination as! UINavigationController
            let destVC2 = destVC.viewControllers[0] as! ModalViewController
            destVC2.sliderVal = slideValue;
            destVC2.sourceViewController = self
        }
    }
}

