import React from 'react';

const Layout: React.FC = ({ children }) => {
    return (
        <div>
            <header>
                <h1>Dental Clinic System</h1>
                {/* Navigation can be added here */}
            </header>
            <main>{children}</main>
            <footer>
                <p>&copy; {new Date().getFullYear()} Dental Clinic. All rights reserved.</p>
            </footer>
        </div>
    );
};

export default Layout;