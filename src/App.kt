import org.w3c.dom.Element
import org.w3c.dom.asList

import kotlin.browser.document
import kotlin.browser.window

/**
 * Created by alejandrorioscalera
 * On 10/9/18
 *
 * -- SOCIAL NETWORKS --
 *
 * GitHub: https://github.com/clonalejandro or @clonalejandro
 * Website: https://clonalejandro.me/
 * Twitter: https://twitter.com/clonalejandro11/ or @clonalejandro11
 * Keybase: https://keybase.io/clonalejandro/
 *
 * -- LICENSE --
 *
 * All rights reserved for clonalejandro ©lazyloadKotlin 2017 / 2018
 */

class App(timeout: Int = 50) {


    /** SMALL CONSTRUCTORS **/

    init {
        window.setTimeout({
            buildImages().forEach {
                val source : String? = it.getAttribute("data-src")

                it.setAttribute("data-src", "")
                it.setAttribute("src", source!!)
            }
        }, timeout)
    }


    /** OTHERS **/

    /**
     * This function initialize the images var
     */
    private fun buildImages() : ArrayList<Element> {
        val generalImages = document.getElementsByTagName("img")
        val images = ArrayList<Element>()

        generalImages.asList().forEach {
            if ( !isNull(it.getAttribute("data-src")) )
                images.add(it)
        }

        return images
    }


    /**
     * This function check if the data is null
     * @param data
     * @return isNull
     */
    private fun <T> isNull(data: T) : Boolean {
        return data == undefined || data == ""
    }


}