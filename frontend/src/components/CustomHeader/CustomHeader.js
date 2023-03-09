import React from "react";
import { HiOutlineSearch } from "react-icons/hi";
import "./CustomHeader.css"

function CustomHeader() {
    return(
        <body>
            <nav>
                <label className="logo">Journal App</label>
                
                <ul> 
                    <input type={Text} placeholder="Search"/>
                </ul>
                <ul className="search-icon">
                    <HiOutlineSearch color="white" className="icoSearch"/> 
                </ul> 
            </nav>
        </body>
    )
}

export default CustomHeader