<?php include 'header.inc.php';?>

<?php include 'left.inc.php';?>
<?php  include 'data.inc.php';

$subtotal=0;
$shipping =200;
$grandtotal = 0;


function outputOrderRow($file, $product, $quantity, $price){
    $src = "images/books/tinysquare/".$file;
    echo "<tr>
    <td><img src=".$src."></td>
    <td class='mdl-data-table__cell--non-numeric'>".$product."</td>
    <td>".$quantity."</td>
    <td>$".number_format($price,2)."</td>
    <td>$".number_format($quantity * $price,2)."</td>
</tr>";

   global $subtotal;
   $subtotal = $subtotal + $price*$quantity;
}

?>
        <main class="mdl-layout__content mdl-color--grey-50">
            <header class="mdl-color--blue-grey-200">
                <h4>Order Summaries</h4>
                <p>Examine your customer orders</p>
            </header>
            <section class="page-content">
                <div class="mdl-grid">
                    <!-- mdl-cell + mdl-card -->
                    <div class="mdl-cell mdl-cell--3-col card-lesson mdl-card mdl-shadow--2dp">
                        <div class="mdl-card__title mdl-color--deep-purple mdl-color-text--white">
                            <h2 class="mdl-card__title-text">My Orders</h2>
                        </div>
                        <div class="mdl-card__supporting-text">
                            <ul class="mdl-list">
                                <?php
                                $data = 500;
                                for ($i=0;$i<=4;$i++){
                                echo "<li><a href='#'>Order #".$data."</a></li>";
                                $data = $data +10;
                                }

                                ?>

                            </ul>
                        </div>
                    </div> <!-- / mdl-cell + mdl-card -->
                    <!-- mdl-cell + mdl-card -->
                    <div class="mdl-cell mdl-cell--9-col card-lesson mdl-card mdl-shadow--2dp">
                        <div class="mdl-card__title mdl-color--orange">
                            <h2 class="mdl-card__title-text">Selected Order: #520</h2>
                        </div>
                        <div class="mdl-card__supporting-text">
                            <table class="mdl-data-table mdl-shadow--2dp">
                                <caption>Customer: <strong>Mount Royal University</strong></caption>
                                <thead>
                                    <tr>
                                        <th>Cover</th>
                                        <th class="mdl-data-table__cell--non-numeric">Title</th>
                                        <th>Quantity</th>
                                        <th>Price</th>
                                        <th>Amount</th>
                                    </tr>
                                </thead>

                                <tbody>
                                    <?php
                                    for($i=1;$i<=4;$i++)
                                    {
                                        $fileName = "file".$i;
                                        $titleName = "title".$i;
                                        $quantityName = "quantity".$i;
                                        $priceName = "price".$i;
                                        outputOrderRow($$fileName, $$titleName, $$quantityName, $$priceName);


                                    }

                                    ?>
                                </tbody>
                                <tfoot>
                                    <tr class="totals">
                                        <td colspan="4">Subtotal</td>
                                        <td>$<?php echo number_format($subtotal,2)?></td>
                                    </tr>
                                    <tr class="totals">
                                        <td colspan="4">Shipping</td>
                                        <td>$<?php
                                        if($subtotal<=10000)
                                            echo $shipping;
                                        else
                                            $shipping =100;
                                            echo $shipping;
                                        ?></td>
                                    </tr>
                                    <tr class="grandtotals">
                                        <td colspan="4">Grand Total</td>
                                        <td>$<?php echo number_format($subtotal+$shipping,2)?></td>
                                    </tr>
                                </tfoot>
                            </table>
                        </div>
                    </div> <!-- / mdl-cell + mdl-card -->
                </div> <!-- / mdl-grid -->
            </section>
        </main>
    </div>
</body>

</html>
header.inc.php:

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Chapter 7</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://code.getmdl.io/1.1.3/material.blue_grey-orange.min.css">
    <link rel="stylesheet" href="css/styles.css">
    <script defer src="https://code.getmdl.io/1.1.3/material.min.js"></script>
</head>

<body>
    <!-- The drawer is always open in large screens. The header is always shown,
even in small screens. -->
    <div class="mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">
        <header class="mdl-layout__header">
            <div class="mdl-layout__header-row">
                <h1 class="mdl-layout-title"><span>CRM</span> Admin</h1>
                <div class="mdl-layout-spacer"></div>
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--expandable mdl-textfield--floating-label mdl-textfield--align-right">
                    <label id="tt2" class="material-icons mdl-badge mdl-badge--overlap"
                        data-badge="5">account_box</label>
                    <div class="mdl-tooltip" for="tt2">Messages</div>
                    <label id="tt3" class="material-icons mdl-badge mdl-badge--overlap"
                        data-badge="4">notifications</label>
                    <div class="mdl-tooltip" for="tt3">Notifications</div>
                    <label class="mdl-button mdl-js-button mdl-button--icon" for="fixed-header-drawer-exp">
                        <i class="material-icons">search</i>
                    </label>
                    <div class="mdl-textfield__expandable-holder">
                        <input class="mdl-textfield__input" type="text" name="sample" id="fixed-header-drawer-exp">
                    </div>
                </div>
            </div>
        </header>
