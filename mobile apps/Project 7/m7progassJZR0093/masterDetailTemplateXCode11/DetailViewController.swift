//
//  DetailViewController.swift
//  masterDetailTemplateXCode11
//
//  Created by R.O. Chapman on 11/18/20.
//  Copyright © 2020 R.O. Chapman. All rights reserved.
//

import UIKit

class DetailViewController: UIViewController {

//    @IBOutlet weak var detailDescriptionLabel: UILabel!
    @IBOutlet var titleTextField: UITextField!
    @IBOutlet var itemTextView: UITextView!
    var masterController: MasterViewController!
    var selectedItem = 1

    func configureView() {
        // Update the user interface for the detail item.
        //if let detail = detailItem {
            if let textbox = titleTextField {
                textbox.text = "New Item"
            }
        if let textview = itemTextView {
            textview.text = "Empty List"
        }
//        masterController?.detailViewController = self
        
        
        //}
//        titleTextField.text = masterController.objects[masterController.selectedItem] textedited method
    }
    
    override func viewWillAppear(_ animated: Bool) {
        configureView();
    }
    override func viewWillDisappear(_ animated: Bool) {
        
        
    }
    
    @objc func cancelButtonPressed(_sender: Any) {
        masterController.navigationController!.popViewController(animated: true)
    }
    
//    @objc func cancelMethod(_ sender: Any) {
//        self.dismiss(animated: true, completion: nil)
//
//    }
    
    @objc func saveMethod(_ sender: Any) {
        
        masterController.objects[selectedItem] = titleTextField.text ?? ""
        selectedItem = selectedItem + 1
        self.navigationController!.popViewController(animated: true)

        
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        configureView()
        let saveButton = UIBarButtonItem(title: "Save", style: .plain, target: self, action: #selector(viewWillDisappear(_:)))
        navigationItem.rightBarButtonItem = saveButton
        let cancelButton = UIBarButtonItem(title: "Cancel", style: .plain, target: self, action: #selector(viewWillDisappear(_:)))
        navigationItem.leftBarButtonItem = cancelButton
    }




}

