//
//  ViewController.swift
//  m3paJZR0093
//
//  Created by Jacob Routzong on 1/30/22.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet var ImageViewer: UIImageView!
    override func viewDidLoad() {
        super.viewDidLoad()
        ImageViewer.image = UIImage(named: "secLogo")
    }
    
    @IBAction func secButton() {
        ImageViewer.image = UIImage(named: "secLogo")
    }
    
    @IBAction func AuButton() {
        ImageViewer.image = UIImage(named: "auburnLogo")
    }
    
    @IBAction func alabamaButton() {
        ImageViewer.image = UIImage(named: "alabamaLogo")
    }
    
}

