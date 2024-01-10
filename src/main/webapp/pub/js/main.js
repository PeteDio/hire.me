(()=>{
    function formatDateTime(dateTimeString) {
        const date = new Date(dateTimeString);
        const options = {
            year: 'numeric',
            month: 'long',
            day: 'numeric',
            hour: 'numeric',
            minute: '2-digit',
            timeZoneName: 'short'
        };
        return date.toLocaleString('en-US', options);
    }

    const thirdTdElements = document.querySelectorAll('tr td:nth-child(3)')
    for (let i = 0; i < thirdTdElements.length; i++) {
        const currentTd = thirdTdElements[i];
        currentTd.textContent = formatDateTime(currentTd.textContent);
    }
})();