package com.gmh.dokterlinkv2_1_1.ModelClasses

class News {

    var Berita : String? = null
    var image: String? = null
    var Desc: String? = null

    constructor(Berita: String?, image: String?, Desc: String?)
    {
        this.Berita = Berita
        this.image  = image
        this.Desc = Desc
    }
}