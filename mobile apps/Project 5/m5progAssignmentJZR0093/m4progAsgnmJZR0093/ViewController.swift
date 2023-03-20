//
//  ViewController.swift
//  m4progAsgnmJZR0093
//
//  Created by Jacob Routzong on 2/6/22.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
    @IBOutlet var loanAmount: UITextField!
    @IBOutlet var numberOfPaymentPeriods: UITextField!
    @IBOutlet var interestRatePerPeriod: UITextField!
    @IBOutlet var result: UILabel!
    
    @IBAction func calculatePayment(_ sender: UIButton) {
        let string1 = loanAmount.text ?? " "
        var LoanAmount: Float = Float(string1) ?? 0
        let string2 = numberOfPaymentPeriods.text ?? " "
        var paymentPeriods: Float = Float(string2) ?? 0 //takes an Integer
        let string3 = interestRatePerPeriod.text ?? " "
        var interestRate: Float = Float(string3) ?? 0
        interestRate = interestRate / 100
        var count: Float = 1
        var sum: Float = 0
        var powerOf: Float = 0
        while count <= paymentPeriods {
            powerOf = pow(1 + interestRate, count)
            sum += (1 / powerOf)
            count += 1
        }
        var results: Float = (LoanAmount / sum)
        results = round(results * 100) / 100
        //rounds to hundredths
        var resultString: String = String(results)
        result.text = "$" + resultString
    }
    
}

