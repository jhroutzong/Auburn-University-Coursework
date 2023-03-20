//
//  MasterViewController.swift
//  masterDetailTemplateXCode11
//
//  Created by R.O. Chapman on 11/18/20.
//  Copyright © 2020 R.O. Chapman. All rights reserved.
//

import UIKit

class MasterViewController: UITableViewController {

    var detailViewController: DetailViewController? = nil
    var objects = [String]()
    var objects2 = [String]()
    
    
    
    @objc func toDetailView(_ sender: Any) {
        
        objects.insert("New Item", at: 0)
        objects2.insert("", at: 0)
           let indexPath = IndexPath(row: 0, section: 0)
           tableView.insertRows(at: [indexPath], with: .automatic)
           performSegue(withIdentifier: "showDetail",sender: self)
        
    }
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        navigationItem.leftBarButtonItem = editButtonItem
        let addButton = UIBarButtonItem(title: "Add", style: .plain, target: self, action: #selector(toDetailView(_:)))
        navigationItem.rightBarButtonItem = addButton
        if let split = splitViewController {
            let controllers = split.viewControllers
            detailViewController = (controllers[controllers.count-1] as! UINavigationController).topViewController as? DetailViewController
        }
        self.navigationController!.popViewController(animated: true)
    }

    override func viewWillAppear(_ animated: Bool) {
        clearsSelectionOnViewWillAppear = splitViewController!.isCollapsed
        super.viewWillAppear(animated)
    }

//    @objc
//    func insertNewObject(_ sender: Any) {
//        detailViewController?.viewWillAppear(animated: true)
////        selectedItem = selectedItem + 1
////        let indexPath = IndexPath(row: 0, section: 0)
////        tableView.insertRows(at: [indexPath], with: .automatic)
//        //insert method
//    }

    // MARK: - Segues

    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "showDetail" {
            //if let indexPath = tableView.indexPathForSelectedRow {
//                let object = objects[indexPath.row]
                let controller = (segue.destination as! UINavigationController).topViewController as! DetailViewController
//                controller.detailItem = object
                controller.navigationItem.leftBarButtonItem = splitViewController?.displayModeButtonItem
                controller.navigationItem.leftItemsSupplementBackButton = true
                detailViewController = controller
                detailViewController?.masterController = self
            //}
        }
    }

    // MARK: - Table View

    override func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return objects.count
    }

    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "Cell", for: indexPath)
        let object = objects[indexPath.row]
        cell.textLabel!.text = object.description
        return cell
    }

    override func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the specified item to be editable.
        return true
    }

    override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCell.EditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete {
            objects.remove(at: indexPath.row)
            tableView.deleteRows(at: [indexPath], with: .fade)
        } else if editingStyle == .insert {
            // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view.
        }
    }


}

