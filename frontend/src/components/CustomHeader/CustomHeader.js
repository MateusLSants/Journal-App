import React from "react";
import { HiOutlineSearch } from "react-icons/hi"
import { HiMenu } from "react-icons/hi"
import "./CustomHeader.css"

function hideOrShow() {
    var sideBarMenu = document.getElementById("side-bar-menu")
    
    if(sideBarMenu.style.display === 'none') {
        sideBarMenu.style.display = 'block'
    } else {
        sideBarMenu.style.display = 'none'
    }
}

function CustomHeader() {
    return(       
        <nav>
            <button className="btn-button-side-bar"
            type="button"
            onClick={hideOrShow}>
                <HiMenu size={"20px"}/>
            </button>
            <div id="side-bar-menu">
                <div className="links-side-bar-menu">
                   <a href="/">home</a>
                   <a href="users">users</a>
                   <a href="news">news</a>
                </div>
            </div>
            
            <label className="logo">Journal App</label>
            <ul> 
                <input type={Text} placeholder="Search"/>
            </ul>
            <ul className="search-icon">
                <HiOutlineSearch color="white"/> 
            </ul> 
        </nav>
    )
}

export default CustomHeader