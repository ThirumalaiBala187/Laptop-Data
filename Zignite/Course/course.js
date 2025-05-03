function changeTab(selectedTab){
    document.querySelectorAll(".cnav").forEach(tab => {
        tab.classList.remove("active");
    });
    selectedTab.classList.add("active");
}