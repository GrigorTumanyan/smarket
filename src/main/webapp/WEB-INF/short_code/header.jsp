<div th:fragment="header">
    <div class="agileits_header">
        <div class="w3l_offers">
            <a href="products.html">Այսօրվա հատուկ առաջարկները !</a>
        </div>
        <div class="w3l_search">
            <form action="#" method="post">
                <input type="text" name="Product" value="Որոնել ապրանք..." onfocus="this.value = '';"
                       onblur="if (this.value == '') {this.value = 'Որոնել ապրանք...';}" required="">
                <input type="submit" value=" ">
            </form>
        </div>
        <div class="product_list_header">
            <form action="#" method="post" class="last">
                <fieldset>
                    <input type="hidden" name="cmd" value="_cart"/>
                    <input type="hidden" name="display" value="1"/>
                    <input type="submit" name="submit" value="Զամբյուղ" class="button"/>
                </fieldset>
            </form>
        </div>
        <div class="w3l_header_right">
            <ul>
                <li class="dropdown profile_details_drop">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"
                                                                                  aria-hidden="true"></i><span
                            class="caret"></span></a>
                    <div class="mega-dropdown-menu">
                        <div class="w3ls_vegetables">
                            <ul class="dropdown-menu drp-mnu">
                                <li><a href="login">Մուտք</a></li>
                                <li><a href="login">Գրանցում</a></li>
                            </ul>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
        <div class="w3l_header_right1">
            <h2><a href="mail.html">Հետադարձ կապ</a></h2>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
