import UIKit

func payment( _ loanAmount: Int, numOfPayments: Int, interestRatePerPayment: Float) -> Float {
    let realInterestRatePerPayment: Float =  interestRatePerPayment / 100
    let realLoanAmount = Float(loanAmount)
    let realNumOfPayments = Float(numOfPayments)
    //creates floats
    var count: Float = 1
    var sum: Float = 0
    var powerOf: Float = 0
    //variables for while statement
    while count <= realNumOfPayments {
        powerOf = pow(1 + realInterestRatePerPayment, count)
        sum += (1 / powerOf)
        count += 1
    }
    var result: Float = (realLoanAmount / sum)
    result = round(result * 100) / 100
    //rounds to hundredths
    print(result)
    return result
}
//main method
//payment(20000, numOfPayments: 72, interestRatePerPayment: 0.36666)
// = 316.56
//payment(150000, numOfPayments: 30, interestRatePerPayment: 5)
// = 9757.71


