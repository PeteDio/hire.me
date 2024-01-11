(()=>{
    function formatDateTime(dateStr) {
        // Explicitly parse the date string using a regular expression
        const dateParts = dateStr.match(/(\d{4})-(\d{2})-(\d{2})T(\d{2}):(\d{2})/);

        if (!dateParts) {
            throw new Error("Invalid date format");
        }

        // Extract year, month, day, hour, and minute
        const year = dateParts[1];
        const month = String(dateParts[2]).padStart(2, "0");
        const day = String(dateParts[3]).padStart(2, "0");
        const hour = parseInt(dateParts[4]);
        const minute = String(dateParts[5]).padStart(2, "0");

        // Convert 24-hour format to 12-hour format with AM/PM
        const ampm = hour >= 12 ? "PM" : "AM";
        const formattedHour = hour % 12 || 12; // Handle midnight (00:00) as 12 AM

        // Format and return the string
        return `${month}/${day}/${year} ${formattedHour}:${minute} ${ampm}`;
    }

    const thirdTdElements = document.querySelectorAll('tr td:nth-child(3)')
    for (let i = 0; i < thirdTdElements.length; i++) {
        const currentTd = thirdTdElements[i];
        currentTd.textContent = formatDateTime(currentTd.textContent);
    }

})();